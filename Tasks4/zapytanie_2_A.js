// 2. Łączną ilość środków pozostałych na kartach kredytowych osób w bazie, w podziale na waluty

db.people.aggregate([
  {
    $project: {
      credit: 1
    }
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
      }
    }
  }
]);
