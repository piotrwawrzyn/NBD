// 7. Usuń z bazy osoby o wzroście przekraczającym 190;
db.people.remove({ height: { $gt: 190 } });
