CREATE TABLE `user` (
  `id` integer PRIMARY KEY,
  `username` varchar(255),
  `password` varchar(255),
  `phone` varchar(255),
  `email` varchar(255),
  `first_name` nvarchar,
  `last_name` nvarchar,
  `dateOfBirth` datetime,
  `gender` varchar(255),
  `created_at` timestamp,
  `modify_at` timestamp,
  `last_login` timestamp
);
