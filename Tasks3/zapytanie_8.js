// 8. Zastąp nazwę miasta „Moscow” przez „Moskwa” u wszystkich osób w bazie
db.people.update(
  { 'location.city': 'Moscow' },
  {
    $set: { 'location.city': 'Moskwa' }
  },
  { multi: true }
);
