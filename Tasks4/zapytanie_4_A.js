// 4. Średnie, minimalne i maksymalne BMI (waga/wzrost^2) dla osób w bazie, w podziale na narodowości

db.people.aggregate([
  {
    $addFields: {
      bmi: {
        $divide: [
          '$weight',
          {
            $multiply: [
              { $divide: ['$height', 100] },
              { $divide: ['$height', 100] }
            ]
          }
        ]
      }
    }
  },
  {
    $group: {
      _id: '$nationality',
      avarageBmi: { $avg: '$bmi' },
      highestBmi: { $max: '$bmi' },
      lowestBmi: { $min: '$bmi' }
    }
  }
]);
