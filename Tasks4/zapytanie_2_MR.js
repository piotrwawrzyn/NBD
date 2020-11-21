// 2. Łączną ilość środków pozostałych na kartach kredytowych osób w bazie, w podziale na waluty

db.people.mapReduce(
  function () {
    this.credit.forEach(cc => {
      emit(cc.currency, cc.balance);
    });
  },
  function (key, values) {
    return Array.sum(values);
  },
  { out: 'balance_sums' }
);
