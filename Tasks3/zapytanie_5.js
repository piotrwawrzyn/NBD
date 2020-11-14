// 5. Lista imion i nazwisk wszystkich osób znajdujących się w bazie oraz miast, w których mieszkają, ale tylko dla osób urodzonych w XXI wieku
db.people.find(
  {
    birth_date: {
      $gte: ISODate('2001-01-01T00:00:00Z'),
      $lt: ISODate('2100-12-31T00:00:00Z')
    }
  },
  { first_name: 1, last_name: 1, location: { city: 1 } }
);
