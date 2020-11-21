// 3. Listę unikalnych zawodów

db.people.aggregate({
  $group: {
    _id: '$job'
  }
});
