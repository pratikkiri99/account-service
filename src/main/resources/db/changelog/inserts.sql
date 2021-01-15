-- inserts for accounts of user1

INSERT INTO ACCOUNT VALUES ('286949', 'SGSavings726', 'Savings', '08/11/2018','SGD', 123.51, 'user1');

INSERT INTO ACCOUNT VALUES ('545622', 'SGCurrent166', 'Current', '08/11/2018','SGD', 8385.93, 'user1');

INSERT INTO ACCOUNT VALUES ('879954', 'AUSavings933', 'Savings', '08/11/2018','AUD', 5896.51, 'user1');

INSERT INTO ACCOUNT VALUES ('458965', 'AUCurrent433', 'Current', '08/11/2018','AUD', 4589.93, 'user1');

-- insert for accounts of user 2
INSERT INTO ACCOUNT VALUES ('286941', 'NZSavings347', 'Savings', '08/11/2018','NZD', 4522.58, 'user2');

INSERT INTO ACCOUNT VALUES ('545621', 'NZCurrent398', 'Current', '08/11/2018','NZD', 75754.93, 'user2');

INSERT INTO ACCOUNT VALUES ('879951', 'AUSavings256', 'Savings', '08/11/2018','AUD', 477547.51, 'user2');

INSERT INTO ACCOUNT VALUES ('458961', 'AUCurrent594', 'Current', '08/11/2018','AUD', 89686.93, 'user2');


-- transaction for user1
INSERT INTO transaction VALUES ('569866', 'Jan 12, 2012',589.83, 'Debit', '', '286949');

INSERT INTO transaction VALUES ('435355', 'Jan 12, 2012',57.37, 'Credit', '', '286949');

INSERT INTO transaction VALUES ('354646', 'Jan 12, 2012',67898.24, 'Debit', '', '286949');

INSERT INTO transaction VALUES ('353465', 'Jan 12, 2012',875.56, 'Debit', '', '545622');

INSERT INTO transaction VALUES ('564633', 'Jan 12, 2012',695.32, 'Credit', '', '545622');

INSERT INTO transaction VALUES ('569861', 'Jan 12, 2012',589.83, 'Debit', '', '879954');

INSERT INTO transaction VALUES ('435351', 'Jan 12, 2012',57.37, 'Credit', '', '879954');

INSERT INTO transaction VALUES ('354641', 'Jan 12, 2012',67898.24, 'Debit', '', '458965');

INSERT INTO transaction VALUES ('353461', 'Jan 12, 2012',875.56, 'Debit', '', '458965');

INSERT INTO transaction VALUES ('564631', 'Jan 12, 2012',695.32, 'Credit', '', '458965');

-- transaction for user 2
INSERT INTO transaction VALUES ('63663', 'Jan 12, 2012',589.83, 'Debit', '', '286941');

INSERT INTO transaction VALUES ('75563', 'Jan 12, 2012',57.37, 'Credit', '', '286941');

INSERT INTO transaction VALUES ('78754', 'Jan 12, 2012',67898.24, 'Debit', '', '545621');

INSERT INTO transaction VALUES ('24546', 'Jan 12, 2012',875.56, 'Debit', '', '545621');

INSERT INTO transaction VALUES ('85636', 'Jan 12, 2012',695.32, 'Credit', '', '545621');

INSERT INTO transaction VALUES ('98960', 'Jan 12, 2012',589.83, 'Debit', '', '879951');

INSERT INTO transaction VALUES ('435352', 'Jan 12, 2012',57.37, 'Credit', '', '879951');

INSERT INTO transaction VALUES ('354642', 'Jan 12, 2012',67898.24, 'Debit', '', '879951');

INSERT INTO transaction VALUES ('353462', 'Jan 12, 2012',875.56, 'Debit', '', '458961');

INSERT INTO transaction VALUES ('564632', 'Jan 12, 2012',695.32, 'Credit', '', '458961');
