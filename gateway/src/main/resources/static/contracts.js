var contracts = [];

function findContract(contractId) {
  return contracts[findContractKey(contractId)];
}

function findContractKey(contractId) {
  for (var key = 0; key < contracts.length; key++) {
    if (contracts[key].id == contractId) {
      return key;
    }
  }
}

var contractService = {
  findAll(fn) {
    axios
      .get('/api/contracts')
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  findById(id, fn) {
    axios
      .get('/api/contracts/' + id)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  create(contract, fn) {
    axios
      .post('/api/contracts', contract)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  update(id, contract, fn) {
    axios
      .put('/api/contracts/' + id, contract)
      .then(response => fn(response))
      .catch(error => console.log(error))
  },

  deleteContract(id, fn) {
    axios
      .delete('/api/contracts/' + id)
      .then(response => fn(response))
      .catch(error => console.log(error))
  }
}

var List = Vue.extend({
  template: '#contract-list',
  data: function () {
    return { contracts: [], searchKey: '' };
  },
  computed: {
    filteredContracts() {
      return this.contracts.filter((contract) => {
        return contract.tenant.name.indexOf(this.searchKey) > -1
          || contract.hoNumber.indexOf(this.searchKey) > -1
          || contract.contractYear.indexOf(this.searchKey) > -1
      })
    }
  },
  mounted() {
    contractService.findAll(r => { this.contracts = r.data; contracts = r.data })
  }
});

var Contract = Vue.extend({
  template: '#contract',
  data: function () {
    return { contract: findContract(this.$route.params.contract_id) };
  }
});

var ContractEdit = Vue.extend({
  template: '#contract-edit',
  data: function () {
    return { contract: findContract(this.$route.params.contract_id) };
  },
  methods: {
    updateContract: function () {
      contractService.update(this.contract.id, this.contract, r => router.push('/'))
    }
  }
});

var ContractDelete = Vue.extend({
  template: '#contract-delete',
  data: function () {
    return { contract: findContract(this.$route.params.contract_id) };
  },
  methods: {
    deleteContract: function () {
      contractService.deleteContract(this.contract.id, r => router.push('/'))
    }
  }
});

var AddContract = Vue.extend({
  template: '#add-contract',
  data() {
    return {
      contract: {
        contractNumber: '',
        contractYear: '',
        dongNumber: '',
        hoNumber: '',
        contractDate: '',
        rentalType: '',
        deposit: 0,
        monthlyRent: 0,
        contractPeriodStart: '',
        contractPeriodEnd: '',
        earnestPaymentDate: '',
        earnest: 0,
        secondPayment: 0,
        secondPaymentDate: '',
        balance: 0,
        balancePaymentDate: '',
        rentPaymentDate: '',
        specialContract: '',
        tenant: { name: '', phoneNumber: '', address: '', birthDate: '', registrationNumber: '' }
      }
    }
  },
  methods: {
    createContract() {
      contractService.create(this.contract, r => router.push('/'))
    }
  }
});

var router = new VueRouter({
  routes: [
    { path: '/', component: List },
    { path: '/contract/:contract_id', component: Contract, name: 'contract' },
    { path: '/add-contract', component: AddContract },
    { path: '/contract/:contract_id/edit', component: ContractEdit, name: 'contract-edit' },
    { path: '/contract/:contract_id/delete', component: ContractDelete, name: 'contract-delete' }
  ]
});

new Vue({
  router
}).$mount('#app')
