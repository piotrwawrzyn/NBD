// 1. Średnią wagę i wzrost osób w bazie z podziałem na płeć (tzn. osobno mężczyzn, osobno kobiet)

db.people.mapReduce(
  function () {
    emit(this.sex, { weight: this.weight, height: this.height });
  },

  function (key, values) {
    let sumWeight = 0;
    let sumHeight = 0;

    values.forEach(element => {
      sumWeight += element.weight;
      sumHeight += element.height;
    });

    return {
      averageWeight: sumWeight / values.length,
      averageHeight: sumHeight / values.length
    };
  },
  { out: 'average_weight_and_height' }
);
