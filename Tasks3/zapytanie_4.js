// 4. Lista wszystkich osób znajdujących się w bazie o wadze z przedziału <68, 71.5)
db.people.find({ weight: { $gte: 68, $lt: 71.5 } });
