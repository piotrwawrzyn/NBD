// 5. Średnia i łączna ilość środków na kartach kredytowych kobiet narodowości polskiej w podziale na waluty

db.people.aggregate([
  {
    $match: { nationality: 'Poland', sex: 'Female' }
  },
  {
    $unwind: {
      path: '$credit'
    }
  },
  {
    $group: {
      _id: '$credit.currency',
      total: {
        $sum: '$credit.balance'
      },
      avarage: {
        $avg: '$credit.balance'
      }
    }
  }
]);
