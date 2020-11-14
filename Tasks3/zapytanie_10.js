// 10. Usuń u wszystkich osób o zawodzie „Editor” własność „email”
db.people.update(
  { job: 'Editor' },
  { $unset: { email: true } },
  { multi: true }
);
