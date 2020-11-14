// 6. Dodaj siebie do bazy, zgodnie z formatem danych użytych dla innych osób (dane dotyczące karty kredytowej, adresu zamieszkania i wagi mogą być fikcyjne)
db.people.insert({
  sex: 'Male',
  first_name: 'Piotr',
  last_name: 'Wawrzynkiewicz',
  job: 'Student',
  email: 'pio.wawrzynkiewicz@gmail.com',
  location: {
    city: 'Warsaw',
    address: { streetname: 'Lodowa', streetnumber: '42' }
  },
  description: "I'm a motivated developer",
  height: 180,
  weight: 70,
  birth_date: '1997-12-24T05:44:11Z',
  nationality: 'Poland',
  credit: [
    {
      type: 'mastercard',
      number: '5586083121891962',
      currency: 'PLN',
      balance: '200'
    }
  ]
});
