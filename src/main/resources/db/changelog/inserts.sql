-- inserts for accounts of user1

INSERT INTO ACCOUNT VALUES ('286949', 'SGSavingsUser1', 'Savings', '2018-11-08','SGD', 123.51, 'user1');

INSERT INTO ACCOUNT VALUES ('545622', 'SGCurrentUser1', 'Current', '2018-11-08','SGD', 8385.93, 'user1');

INSERT INTO ACCOUNT VALUES ('879954', 'AUSavingsUser1', 'Savings', '2018-11-08','AUD', 5896.51, 'user1');

INSERT INTO ACCOUNT VALUES ('458965', 'AUCurrentUser1', 'Current', '2018-11-08','AUD', 4589.93, 'user1');

-- insert for accounts of user 2
INSERT INTO ACCOUNT VALUES ('286941', 'NZSavingsUser2', 'Savings', '2018-11-08','NZD', 4522.58, 'user2');

INSERT INTO ACCOUNT VALUES ('545621', 'NZCurrentUser2', 'Current', '2018-11-08','NZD', 75754.93, 'user2');

INSERT INTO ACCOUNT VALUES ('879951', 'AUSavingsUser2', 'Savings', '2018-11-08','AUD', 477547.51, 'user2');

INSERT INTO ACCOUNT VALUES ('458961', 'AUCurrentUser2', 'Current', '2018-11-08','AUD', 89686.93, 'user2');


-- transaction for user1
INSERT INTO transaction VALUES ('569866', '2018-11-08',589.83, 'Debit', '', '286949');

INSERT INTO transaction VALUES ('435355', '2018-11-09',57.37, 'Credit', '', '286949');

INSERT INTO transaction VALUES ('354646', '2018-11-10',67898.24, 'Debit', '', '286949');

INSERT INTO transaction VALUES ('353465', '2018-11-08',875.56, 'Debit', '', '545622');

INSERT INTO transaction VALUES ('564633', '2018-11-09',695.32, 'Credit', '', '545622');

INSERT INTO transaction VALUES ('569861', '2018-11-08',589.83, 'Debit', '', '879954');

INSERT INTO transaction VALUES ('435351', '2018-11-09',57.37, 'Credit', '', '879954');

INSERT INTO transaction VALUES ('354641', '2018-11-10',67898.24, 'Debit', '', '458965');

INSERT INTO transaction VALUES ('353461', '2018-11-08',875.56, 'Debit', '', '458965');

INSERT INTO transaction VALUES ('564631', '2018-11-09',695.32, 'Credit', '', '458965');

-- transaction for user 2
INSERT INTO transaction VALUES ('63663', '2018-11-08',589.83, 'Debit', '', '286941');

INSERT INTO transaction VALUES ('75563', '2018-11-09',57.37, 'Credit', '', '286941');

INSERT INTO transaction VALUES ('78754', '2018-11-10',67898.24, 'Debit', '', '545621');

INSERT INTO transaction VALUES ('24546', '2018-11-08',875.56, 'Debit', '', '545621');

INSERT INTO transaction VALUES ('85636', '2018-11-09',695.32, 'Credit', '', '545621');

INSERT INTO transaction VALUES ('98960', '2018-11-08',589.83, 'Debit', '', '879951');

INSERT INTO transaction VALUES ('435352', '2018-11-09',57.37, 'Credit', '', '879951');

INSERT INTO transaction VALUES ('354642', '2018-11-10',67898.24, 'Debit', '', '879951');

INSERT INTO transaction VALUES ('353462', '2018-11-08',875.56, 'Debit', '', '458961');

INSERT INTO transaction VALUES ('564632', '2018-11-09',695.32, 'Credit', '', '458961');
