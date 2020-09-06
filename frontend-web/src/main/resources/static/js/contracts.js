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
      //console.log(this);
      return this.contracts.filter((contract) => {
        return contract.tenant.name.indexOf(this.searchKey) > -1
          || contract.hoNumber.indexOf(this.searchKey) > -1
          || contract.contractYear.indexOf(this.searchKey) > -1
      })
    }
  },
  mounted() {
    contractService.findAll(r => { this.contracts = r.data; contracts = r.data });
    feather.replace();
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
      contractService.update(this.contract.id, this.contract, r => { this.contracts = r.data; contracts = r.data });
      router.push('/');
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
      contractService.deleteContract(this.contract.id, r => { this.contracts = r.data; contracts = r.data });
      router.push('/');
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
        rentalType: '월세',
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
      contractService.create(this.contract, r => { this.contracts.push(r.data); contracts = r.data });

      // 저장 후 다음 처리 부분 수정 필요.
      router.push('/');
    }
  }
});

var ContractPrint = Vue.extend({
  template: '#contract-print',
  data: function () {
    return { contract: findContract(this.$route.params.contract_id) };
  },
  methods: {
    printContract: function () {

      router.redirect('/contract-print/:contract_id');
    }
  },
  mounted() {
  var contractId = this.$route.params.contract_id;
    //alert(contractId);
    location.href='/contract-print/'+ contractId;
  }
});

var router = new VueRouter({
  routes: [
    { path: '/', component: List },
    { path: '/contract/:contract_id', component: Contract, name: 'contract' },
    { path: '/add-contract', component: AddContract },
    { path: '/contract/:contract_id/edit', component: ContractEdit, name: 'contract-edit' },
    { path: '/contract/:contract_id/print', component: ContractPrint, name: 'contract-print' },
    { path: '/contract/:contract_id/delete', component: ContractDelete, name: 'contract-delete' }
  ]
});

new Vue({
  router
}).$mount('#app');

/*import Contract-print from './contract-print/contract-print.vue';

export default {
  components: {
    Contract-print
  }
};
*/