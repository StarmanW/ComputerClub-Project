-- FACULTY TABLE
CREATE TABLE FACULTY (FACULTYID VARCHAR(4) NOT NULL, FACULTYNAME VARCHAR(200) NOT NULL, PRIMARY KEY (FACULTYID));
INSERT INTO NBUSER.FACULTY VALUES ('FASC', 'Faculty of Applied Science and Computing');
INSERT INTO NBUSER.FACULTY VALUES ('FAFB', 'Faculty of Accounting, Finance & Business');
INSERT INTO NBUSER.FACULTY VALUES ('FSAH', 'Faculty of Social Science, Arts & Humanities');

-- PROGRAMME TABLE
CREATE TABLE PROGRAMME (PROGID VARCHAR(3) NOT NULL, PROGNAME VARCHAR(200), FACULTYID VARCHAR(4) NOT NULL, PRIMARY KEY (PROGID));
INSERT INTO NBUSER.PROGRAMME VALUES ('DIA', 'Diploma in Science (Information Systems Engineering)', 'FASC');
INSERT INTO NBUSER.PROGRAMME VALUES ('DHM', 'Diploma in Hotel Management', 'FSAH');
INSERT INTO NBUSER.PROGRAMME VALUES ('DBU', 'Diploma in Business Studies (Business Administration)', 'FAFB');
INSERT INTO NBUSER.PROGRAMME VALUES ('DMK', 'Diploma in Business Studies (Marketing)', 'FAFB');
INSERT INTO NBUSER.PROGRAMME VALUES ('DAC', 'Diploma in Business Studies (Accounting)', 'FAFB');

-- MEMBER TABLE
CREATE TABLE MEMBERS (MEMBERID VARCHAR(10) NOT NULL, PROGID VARCHAR(3) NOT NULL, FIRSTNAME VARCHAR(255) NOT NULL, LASTNAME VARCHAR(255) NOT NULL, STUDEMAIL VARCHAR(200) NOT NULL, STUDCONTACT VARCHAR(20) NOT NULL, ICNUM VARCHAR(12) NOT NULL, GENDER VARCHAR(1) NOT NULL, MEMFEESTATS BOOLEAN DEFAULT false  NOT NULL, "POSITION" INTEGER NOT NULL, ACADEMICYEAR VARCHAR(9) NOT NULL, PRIMARY KEY (MEMBERID));
INSERT INTO NBUSER.MEMBERS VALUES ('16SMD00990', 'DIA', 'Samuel', 'Wong Kim Foong', 'samuelwkf-sa16@student.tarc.edu.my', '014-5569877', '980714126653', 'M', true, 5, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SMD00882', 'DIA', 'Chong', 'Jia Herng', 'chongjh-sa16@student.tarc.edu.my', '016-2222123', '981130125333', 'M', true, 4, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SMD05943', 'DIA', 'Shirlina', 'Koo Yung Ja', 'kooyj-sa16@student.tarc.edu.my', '019-9988776', '990909125555', 'F', true, 3, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SMD00994', 'DIA', 'Zion', 'Tseu', 'zionT-sa16@student.tarc.edu.my', '014-9881234', '971130125666', 'M', true, 2, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SMD00148', 'DIA', 'Enjiun', 'Tan', 'enjiunT-sa16@student.tarc.edu.my', '014-5628714', '98171125657', 'M', true, 1, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SMD01576', 'DIA', 'Lee', 'Jun Kai', 'leejk-sa16@student.tarc.edu.my', '016-2135745', '981130126343', 'M', true, 1, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SMD01893', 'DIA', 'Belden', 'Wong', 'beldenw-sa16@student.tarc.edu.my', '019-9987687', '990909125735', 'M', true, 1, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SMD02233', 'DIA', 'Woo', 'Guo Hao', 'woogh-sa16@student.tarc.edu.my', '014-9247578', '971130125996', 'M', true, 1, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SMD02372', 'DIA', 'Kelly', 'Chin Yin Yu', 'kellycyy-sa16@student.tarc.edu.my', '014-7892042', '970624125913', 'F', true, 1, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SMD00877', 'DIA', 'Ng', 'Zi Qing', 'ngzq-sa16@student.tarc.edu.my', '016-27827820', '981130125757', 'F', true, 1, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SMD01437', 'DIA', 'Khor', 'Chi Hao', 'khooch-sa16@student.tarc.edu.my', '019-8452832', '990909125665', 'M', true, 1, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SMD04378', 'DIA', 'Thomas', 'Liew', 'thomasles-sa16@student.tarc.edu.my', '014-5858242', '971130125442', 'M', true, 1, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SMD04538', 'DIA', 'Julius', 'Soo', 'juliuss-sa16@student.tarc.edu.my', '014-5757600', '980714125454', 'M', true, 1, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SMD12782', 'DIA', 'Ritchie', 'Reginald', 'richier-sa16@student.tarc.edu.my', '016-5757527', '981130125566', 'M', true, 1, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SHM05837', 'DHM', 'Joyce', 'Lee', 'chuaks-sa16@student.tarc.edu.my', '019-9903587', '990909125782', 'F', true, 1, '2017/2018');
INSERT INTO NBUSER.MEMBERS VALUES ('16SAC14772', 'DAC', 'Sherly', 'Tan', 'SherlyT-sa16@student.tarc.edu.my', '014-9774262', '971130125248', 'F', true, 1, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SMK08572', 'DMK', 'Chistina', 'Lee', 'christinal-sa16@student.tarc.edu.my', '014-5872681', '980714125997', 'F', true, 1, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SBU00247', 'DBU', 'Liona', 'Yap', 'Lionay-sa16@student.tarc.edu.my', '016-7824824', '981130125602', 'F', true, 1, '2017/2018');
INSERT INTO NBUSER.MEMBERS VALUES ('16SHM07727', 'DHM', 'Lo', 'Chun Ha', 'lochunha-sa16@student.tarc.edu.my', '019-7242758', '990909125500', 'F', true, 1, '2017/2018');
INSERT INTO NBUSER.MEMBERS VALUES ('16SBU04278', 'DBU', 'Chia', 'Lian Zhi', 'chialz-sa16@student.tarc.edu.my', '014-1185287', '971130125270', 'F', true, 1, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SAC06741', 'DAC', 'Wong', 'Kim Fok', 'wongkf-sa16@student.tarc.edu.my', '016-2222123', '981130125548', 'M', true, 1, '2016/2017');
INSERT INTO NBUSER.MEMBERS VALUES ('16SHM07377', 'DHM', 'Fanie', 'Lim', 'faniel-sa16@student.tarc.edu.my', '019-9988776', '990909125758', 'F', true, 1, '2017/2018');
INSERT INTO NBUSER.MEMBERS VALUES ('16SAC03840', 'DAC', 'Wong', 'Li Hong', 'wonglh-sa16@student.tarc.edu.my', '014-9881234', '971130125950', 'M', true, 1, '2017/2018');

-- EVENT TABLE
CREATE TABLE EVENT (EVENTID VARCHAR(10) NOT NULL, EVENTNAME VARCHAR(255), EVENTTYPE INTEGER, EVENTDATE VARCHAR(25), EVENTSTARTTIME VARCHAR(20), EVENTENDTIME VARCHAR(20), EVENTLOCATION VARCHAR(255), PRIMARY KEY (EVENTID));
INSERT INTO NBUSER.EVENT VALUES ('E0001', 'Network Security', 3, '2017-11-24', '14:00', '16:00', 'Lot 1-1');
INSERT INTO NBUSER.EVENT VALUES ('E0002', 'Artificial Intelligence and Robotics', 3, '2017-12-01', '14:00', '16:00', 'Computer Lab 1A');
INSERT INTO NBUSER.EVENT VALUES ('E0003', 'Capture The Flag Competition', 5, '2018-01-13', '08:00', '18:00', 'Lot 1-1');
INSERT INTO NBUSER.EVENT VALUES ('E0004', 'Working in the IT fields', 3, '2018-01-19', '14:00', '16:00', 'Computer Lab 1A');
INSERT INTO NBUSER.EVENT VALUES ('E0005', 'Visit to Sabah Net', 4, '2018-01-25', '08:00', '12:00', '1B, Ground Floor, Likas Square Commercial Centre');
INSERT INTO NBUSER.EVENT VALUES ('E0006', 'ROBO Tournaments', 5, '2018-02-09', '09:00', '16:00', 'Lot 1-1');
INSERT INTO NBUSER.EVENT VALUES ('E0007', 'The Future of Computing', 3, '2018-03-13', '13:00', '15:00', 'Computer Lab 5-1');

-- EVENTMEMBER TABLE (BRIDGE TABLE FOR MEMBER && EVENT)
CREATE TABLE EVENTMEMBER (EVENTMEMBERID VARCHAR(10) NOT NULL, MEMBERID VARCHAR(10), EVENTID VARCHAR(10), PRIMARY KEY (EVENTMEMBERID));
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0001', '16SMD00990', 'E0001');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0002', '16SMD00882', 'E0001');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0003', '16SMD05943', 'E0001');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0004', '16SMD00994', 'E0001');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0005', '16SMD00148', 'E0001');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0006', '16SMD01576', 'E0001');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0007', '16SMD01893', 'E0001');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0008', '16SMD02233', 'E0001');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0009', '16SMD02372', 'E0001');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0010', '16SMD00877', 'E0001');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0011', '16SMD01437', 'E0001');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0012', '16SMD04378', 'E0001');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0013', '16SMD04538', 'E0001');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0014', '16SMD12782', 'E0001');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0015', '16SMD00990', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0016', '16SMD00882', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0017', '16SMD05943', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0018', '16SMD00994', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0019', '16SMD00148', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0020', '16SMD01576', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0021', '16SMD01893', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0022', '16SMD02233', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0023', '16SMD02372', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0024', '16SMD00877', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0025', '16SMD01437', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0026', '16SMD04378', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0027', '16SMD04538', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0028', '16SMD12782', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0029', '16SAC14772', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0030', '16SBU00247', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0031', '16SHM07727', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0032', '16SMK08572', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0033', '16SBU04278', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0034', '16SHM07377', 'E0002');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0035', '16SMD00990', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0036', '16SMD00882', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0037', '16SMD05943', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0038', '16SMD00994', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0039', '16SMD00148', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0040', '16SMD01576', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0041', '16SMD01893', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0042', '16SMD02233', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0043', '16SMD02372', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0044', '16SMD00877', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0045', '16SMD01437', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0046', '16SMD04378', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0047', '16SMD04538', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0048', '16SMD12782', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0049', '16SHM05837', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0050', '16SAC14772', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0051', '16SMK08572', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0052', '16SBU00247', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0053', '16SHM07727', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0054', '16SBU04278', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0055', '16SAC06741', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0056', '16SHM07377', 'E0003');
INSERT INTO NBUSER.EVENTMEMBER VALUES ('EM0057', '16SAC03840', 'E0003');

-- EVENTCOLLABORATOR TABLE (BRIDGE TABLE FOR EVENT && COLLABORATOR)
CREATE TABLE EVENTCOLLABORATOR (EVENTCOLLABID VARCHAR(10) NOT NULL, EVENTID VARCHAR(10), COLLABID VARCHAR(10), PRIMARY KEY (EVENTCOLLABID));
INSERT INTO NBUSER.EVENTCOLLABORATOR VALUES ('EC0001', 'E0001', 'C0001');
INSERT INTO NBUSER.EVENTCOLLABORATOR VALUES ('EC0002', 'E0002', 'C0002');
INSERT INTO NBUSER.EVENTCOLLABORATOR VALUES ('EC0003', 'E0003', 'C0003');

-- COLLABORATOR TABLE
CREATE TABLE COLLABORATOR (COLLABID VARCHAR(10) NOT NULL, COLLABNAME VARCHAR(255) NOT NULL, COLLABTYPE INTEGER NOT NULL, COLLABCONTACT VARCHAR(20) NOT NULL, COLLABEMAIL VARCHAR(255), ADDITIONALNOTES VARCHAR(255), PRIMARY KEY (COLLABID));
INSERT INTO NBUSER.COLLABORATOR VALUES ('C0001', 'CompTIA', 1, '866 835-8020 ', 'info_india@comptia.org', 'CompTIA has presented their experienced Network Security employees to provide talks on the topic "Network Security".');
INSERT INTO NBUSER.COLLABORATOR VALUES ('C0002', 'SK-TEC Automation & Engineering Sdn. Bhd.', 1, '03-8060 8771', 'sales@sk-tec.com.my', '');
INSERT INTO NBUSER.COLLABORATOR VALUES ('C0003', 'ASUS Malaysia', 1, '1300-88-3495', 'asustechsupport@asustech.com.my', '');

-- SPONSOREDITEM TABLE
CREATE TABLE SPONSOREDITEM (ITEMID VARCHAR(10) NOT NULL, COLLABID VARCHAR(10) NOT NULL, ITEMTYPE INTEGER NOT NULL, ITEMNAME VARCHAR(255) NOT NULL, ITEMQUANTITY INTEGER NOT NULL, PRIMARY KEY (ITEMID));
INSERT INTO NBUSER.SPONSOREDITEM VALUES ('IT0001', 'C0003', 5, 'ASUS ROG Rapture GT-AC5300', 2);
INSERT INTO NBUSER.SPONSOREDITEM VALUES ('IT0002', 'C0003', 5, 'ASUS ROG ZEPHYRUS laptop', 12);

-- SPONSOREDITEM TABLE
CREATE TABLE EVENTITEM (EVENTITEMID VARCHAR(10)  NOT NULL, EVENTID VARCHAR(10), ITEMID VARCHAR(10), PRIMARY KEY (EVENTITEMID));
INSERT INTO NBUSER.EVENTITEM VALUES ('EI0001', 'E0003', 'IT0001');
INSERT INTO NBUSER.EVENTITEM VALUES ('EI0002', 'E0003', 'IT0002');

-- LOGIN TABLE
CREATE TABLE LOGIN (LNAME VARCHAR(255), LPASS VARCHAR(255), URIGHTS VARCHAR(10), PRIMARY KEY (LNAME));
INSERT INTO NBUSER.LOGIN VALUES ('2e18a828c289935885facf07ceff509693eb5bd407aec911c93b8d07560998bd', '0d777eb4beb78b2baa9a9ebd2b6685615a4128652868067b004d696e7c165fa0', 'admin');
INSERT INTO NBUSER.LOGIN VALUES ('1670a6ce28d44526abd080849d0a8c20ebf0a8c3ef8445e8d0c6ce914c86f204', '9eab67c24538fd1ca90a24f608929ac153e896f4ba6de22d8296546015a5bc03', 'member');

-- ALTER TABLE TO ADD FOREIGN KEY
ALTER TABLE EVENTMEMBER ADD FOREIGN KEY(MEMBERID) REFERENCES MEMBERS;
ALTER TABLE EVENTMEMBER ADD FOREIGN KEY(EVENTID) REFERENCES EVENT;
ALTER TABLE EVENTCOLLABORATOR ADD FOREIGN KEY(EVENTID) REFERENCES EVENT;
ALTER TABLE EVENTCOLLABORATOR ADD FOREIGN KEY(COLLABID) REFERENCES COLLABORATOR;
ALTER TABLE EVENTITEM ADD FOREIGN KEY(EVENTID) REFERENCES EVENT;
ALTER TABLE EVENTITEM ADD FOREIGN KEY(ITEMID) REFERENCES SPONSOREDITEM;
ALTER TABLE SPONSOREDITEM ADD FOREIGN KEY(COLLABID) REFERENCES COLLABORATOR;