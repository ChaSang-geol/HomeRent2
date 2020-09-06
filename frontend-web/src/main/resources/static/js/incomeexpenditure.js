var select_classification=[
    {id:1, txt: '지출' },
    {id:2, txt: '수입' }
]
var select_accountsubject= [
		{id: 1, txt: '지급수수료'},
		{id: 2, txt: '지급이자'},
		{id: 3, txt: '수선비'},
		{id: 4, txt: '공과금'},
		{id: 5, txt: '잡비'},
		{id: 6, txt: '임대료'}
]

function numberWithCommas(x) {
  if (x=='' || x==null) {
    return '0'
  }
  return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

var app = new Vue({
  el: '#main',
  data() {
    return {
      input_classification: '지출',
      input_occurrenceDate: null,
      input_correspondent: null,
      input_summary: null,
      input_amount: null,
      input_accountSubject: null,
      input_dongNumber: '109',
      input_hoNumber: null,
      input_createDate: null,
      input_updateDate: null,
      input_id: null,
      incomeexpenditures: [],
      searchKey: '',
      select_classification,
      select_accountsubject //,
      /*incomeexpenditure : {
        classification: '지출',  // 구분 : 수입/지출
        occurrenceDate: null, // 발생일자
        correspondent: null, // 거래처명
        summary: null, // 적요
        amount: 0, // 금액
        accountSubject: null, // 계정과목
        dongNumber: '109', // 동
        hoNumber: null, // 호
        createDate: null,
        updateDate: null,
        id: null

      }*/
    }
  },
  computed: {
    filteredIncomeExpenditures() {
//      console.log(this);
      for(var i=0; i< this.incomeexpenditures.length; i++) {
         this.incomeexpenditures[i].amount = numberWithCommas(this.incomeexpenditures[i].amount);
//         console.log(this.incomeexpenditures[i].amount);
//         console.log('filteredIncomeExpenditures 실행: '+i);
      }
      return this.incomeexpenditures.filter((incomeexpenditure) => {
        return incomeexpenditure.classification.indexOf(this.searchKey) > -1
          || incomeexpenditure.occurrenceDate.indexOf(this.searchKey) > -1
          || incomeexpenditure.correspondent.indexOf(this.searchKey) > -1
          || incomeexpenditure.accountSubject.indexOf(this.searchKey) > -1
          || incomeexpenditure.hoNumber.indexOf(this.searchKey) > -1
          || incomeexpenditure.dongNumber.indexOf(this.searchKey) > -1
          || incomeexpenditure.summary.indexOf(this.searchKey) > -1

      })
    }
  },
  mounted(){
            //this.getIncomeExpenditures();

            //console.log(this);
            this.getIncomeExpenditures(r => {
                this.incomeexpenditures = r.data;
                incomeexpenditures = r.data;
//                console.log('getIncomeExpenditures 실행');
                for(var i=0; i< incomeexpenditures.length; i++) {
                   this.incomeexpenditures[i].amount = numberWithCommas(this.incomeexpenditures[i].amount);
//                   console.log(incomeexpenditures[i].amount);
//                   console.log('getIncomeExpenditures 실행2: '+i);
                }

            });

            feather.replace();
        },
        methods: {

            getIncomeExpenditures: function () {
                axios
                    .get("/api/incomeExpenditures")
                    .then(response => (this.incomeexpenditures = response.data._embedded.incomeExpenditures))
                    .catch(error => console.log(error));
                    //console.log( this.incomeexpenditures );

            },
            postIncomeExpenditure: function (event) {
                // Creating
                if (this.input_id == '' || this.input_id == null) {
                    axios
                        .post("/api/incomeExpenditures", {
                            "classification": this.input_classification,
                            "occurrenceDate": this.input_occurrenceDate,
                            "correspondent": this.input_correspondent,
                            "summary": this.input_summary,
                            "amount": this.input_amount,
                            "accountSubject": this.input_accountSubject,
                            "dongNumber": this.input_dongNumber,
                            "hoNumber": this.input_hoNumber,
                            "createDate": this.input_createDate,
                            "updateDate": this.input_updateDate
                        })
                        .then(savedIncomeExpenditure => {
                            this.incomeexpenditures.push(savedIncomeExpenditure.data);
                            this.input_classification= '지출';  // 구분 : 수입/지출
                            this.input_occurrenceDate= null; // 발생일자
                            this.input_correspondent= null; // 거래처명
                            this.input_summary= null; // 적요
                            this.input_amount= ''; // 금액
                            this.input_accountSubject= null; // 계정과목
                            this.input_dongNumber= '109'; // 동
                            this.input_hoNumber= null; // 호
                            this.input_createDate= null;
                            this.input_updateDate= null;
                            this.input_id = '';
                        })
                } else { // Updating
                    axios
                        .post("/api/incomeExpenditures", {
                            "id": this.input_id,
                            "classification": this.input_classification,
                            "occurrenceDate": this.input_occurrenceDate,
                            "correspondent": this.input_correspondent,
                            "summary": this.input_summary,
                            "amount": this.input_amount,
                            "accountSubject": this.input_accountSubject,
                            "dongNumber": this.input_dongNumber,
                            "hoNumber": this.input_hoNumber,
                            "createDate": this.input_createDate,
                            "updateDate": this.input_updateDate
                        })
                        .then(savedIncomeExpenditure => {
                            this.getIncomeExpenditures();
                            this.input_id = '';
                            this.input_classification = '지출';
                            this.input_occurrenceDate = '';
                            this.input_correspondent = '';
                            this.input_summary = '';
                            this.input_amount = '';
                            this.input_accountSubject = null;
                            this.input_dongNumber = '109';
                            this.input_hoNumber = '';
                            this.input_createDate = '';
                            this.input_updateDate = '';
                        })
                }
            },
            editIncomeExpenditure: function (incomeexpenditure) {
                this.input_id = incomeexpenditure.id;
                this.input_classification = incomeexpenditure.classification
                this.input_occurrenceDate = incomeexpenditure.occurrenceDate;
                this.input_correspondent = incomeexpenditure.correspondent;
                this.input_summary = incomeexpenditure.summary;
                this.input_amount = incomeexpenditure.amount.replace(/,/g, '');
                this.input_accountSubject = incomeexpenditure.accountSubject;
                this.input_dongNumber = incomeexpenditure.dongNumber;
                this.input_hoNumber = incomeexpenditure.hoNumber;
                this.input_createDate = incomeexpenditure.createDate;
                this.input_updateDate = incomeexpenditure.updateDate;

                document.getElementById('incomeexpenditureForm')
                    .setAttribute("class", document.getElementById('incomeexpenditureForm').getAttribute("class") + " show");
            },
            deleteIncomeExpenditure: async function (incomeexpenditure) {
                var res = confirm("이 건을 삭제하시겠습니까?");
                if(res == true){
                    await axios
                    .delete("/api/incomeExpenditures/" + incomeexpenditure.id)
                    .catch(error => console.log(error));
                    this.getIncomeExpenditures();
                }
                else if(res == false){
                    return null
                }

<!--                axios-->
<!--                  .delete('http://localhost:8081/api/incomeExpenditures/' + incomeexpenditure.id)-->
<!--                  .then(response => fn(response))-->
<!--                  .catch(error => console.log(error))-->


            }
        }
});

