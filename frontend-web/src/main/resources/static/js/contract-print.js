var contract = {};
var contractId = document.getElementById('contractId').value;

function fnPrint() {
        document.body.innerHTML = contents.innerHTML;
        //factory.printing.header = "";   //머릿말 설정
        //factory.printing.footer = "";   //꼬릿말 설정
        //factory.printing.portrait = true;  //출력방향 설정: true-가로, false-세로
        //factory.printing.leftMargin = 0.5;  //왼쪽 여백 설정
        //factory.printing.topMargin = 5;  //위쪽 여백 설정
        //factory.printing.rightMargin = 0.5;  //오른쪽 여백 설정
        //factory.printing.bottomMargin = 0.5;  //아래쪽 여백 설정
        //factory.printing.printBackground = true; //배경이미지 출력 설정:라이센스 필요
        //factory.printing.Print(true);   //출력하기

        window.print();
        location.href='/contracts';
        return false;
};

function printElement(elementRef) {
  let app = document.getElementById('app') ;
  const printContents = elementRef.innerHTML ;
  let printDiv = document.createElement('DIV') ;
  document.body.appendChild(printDiv) ;
  printDiv.innerHTML = printContents ;
  app.style.display = 'none' ;
  window.print() ;
  app.style.display = 'block' ;
  printDiv.style.display = 'none' ;
  printDiv.innerHTML = '' ;
}

function onPrint() {
  const html = document.querySelector('html');
  const printContents = document.querySelector('.modal-body').innerHTML;
  const printDiv = document.createElement('DIV');
  printDiv.className = 'print-div';

  html.appendChild(printDiv);
  printDiv.innerHTML = printContents;
  document.body.style.display = 'none';
  //document.body.innerHTML = printContents;
  window.print();
  //document.body.innerHTML = html;
  document.body.style.display = 'block';
  printDiv.style.display = 'none';
}

$('#contractPrintModal').modal();

function numberWithCommas(x) {
  if (x=='' || x==null) {
    return '0'
  }
  return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function dateToString(str) {
  if (str=='' || str==null) {
    return "  .  .  ."
  }
  var year = str.substring(0,4);
  var month = str.substring(5,7);
  var day = str.substring(8,10);
  return year +"년 " + month +"월 " + day +"일";
}

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

function contractfindById(id, fn) {
    axios
      .get('/api/contracts/' + id)
      .then(response => fn(response))
      .catch(error => console.log(error))
}

var app = new Vue({
  el: '#main',
    data: function () {
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
          },
          contracts: null
        }
    },
    mounted() {
        //var contracts = {};
        this.getPrintContract();
        //this.contract = this.contracts;
        //console.log(contract);

        //contracts = this.contract;



    },
    methods: {
        getPrintContract: function () {
            axios
                .get('/api/contracts/' + contractId)
                .then(response => {
                  this.contract = response.data; contract = response.data;
                  //console.log(contract);
                  this.contract.deposit = numberWithCommas(contract.deposit);
                  this.contract.monthlyRent = numberWithCommas(this.contract.monthlyRent);
                  this.contract.earnest = numberWithCommas(this.contract.earnest);
                  this.contract.secondPayment = numberWithCommas(this.contract.secondPayment);
                  this.contract.balance = numberWithCommas(this.contract.balance);
                  this.contract.contractDate = dateToString(this.contract.contractDate);
                  this.contract.contractPeriodStart = dateToString(this.contract.contractPeriodStart);
                  this.contract.contractPeriodEnd = dateToString(this.contract.contractPeriodEnd);
                  this.contract.earnestPaymentDate = dateToString(this.contract.earnestPaymentDate);
                  this.contract.secondPaymentDate = dateToString(this.contract.secondPaymentDate);
                  this.contract.balancePaymentDate = dateToString(this.contract.balancePaymentDate);
                });


        },
        getNumberCommas: function () {
          this.contract.deposit = numberWithCommas(this.contract.deposit);
          this.contract.monthlyRent = numberWithCommas(this.contract.monthlyRent);
          this.contract.earnest = numberWithCommas(this.contract.earnest);
          this.contract.secondPayment = numberWithCommas(this.contract.secondPayment);
          this.contract.balance = numberWithCommas(this.contract.balance);
        }
    }
})
