-- FACULTY TABLE
CREATE TABLE FACULTY (FACULTYID VARCHAR(4) NOT NULL, FACULTYNAME VARCHAR(200) NOT NULL, PRIMARY KEY (FACULTYID));
INSERT INTO NBUSER.FACULTY (FACULTYID, FACULTYNAME) 
	VALUES ('FASC', 'Faculty of Applied Science and Computing');
INSERT INTO NBUSER.FACULTY (FACULTYID, FACULTYNAME) 
	VALUES ('FAFB', 'Faculty of Accounting, Finance & Business');
INSERT INTO NBUSER.FACULTY (FACULTYID, FACULTYNAME) 
	VALUES ('FSAH', 'Faculty of Social Science, Arts & Humanities');

-- PROGRAMME TABLE
CREATE TABLE PROGRAMME (PROGID VARCHAR(3) NOT NULL, PROGNAME VARCHAR(200), FACULTYID VARCHAR(4) NOT NULL, PRIMARY KEY (PROGID));
INSERT INTO NBUSER.PROGRAMME (PROGID, PROGNAME, FACULTYID) 
	VALUES ('DIA', 'Diploma in Science (Information Systems Engineering)', 'FASC');
INSERT INTO NBUSER.PROGRAMME (PROGID, PROGNAME, FACULTYID) 
	VALUES ('DHM', 'Diploma in Hotel Management', 'FSAH');


-- MEMBER TABLE
CREATE TABLE MEMBERS (MEMBERID VARCHAR(10) NOT NULL, PROGID VARCHAR(3) NOT NULL, FIRSTNAME VARCHAR(255) NOT NULL, LASTNAME VARCHAR(255) NOT NULL, STUDEMAIL VARCHAR(200) NOT NULL, STUDCONTACT VARCHAR(20) NOT NULL, ICNUM VARCHAR(12) NOT NULL, PASS VARCHAR(255) NOT NULL, GENDER VARCHAR(1) NOT NULL, MEMFEESTATS BOOLEAN DEFAULT false  NOT NULL, "POSITION" INTEGER NOT NULL, ACADEMICYEAR VARCHAR(9) NOT NULL, PRIMARY KEY (MEMBERID));
INSERT INTO NBUSER.MEMBERS (MEMBERID, PROGID, FIRSTNAME, LASTNAME, STUDEMAIL, STUDCONTACT, ICNUM, PASS, GENDER, MEMFEESTATS, "POSITION", ACADEMICYEAR) 
	VALUES ('16SMD00990', 'DIA', 'Samuel', 'Wong Kim Foong', 'samuelwkf-sa16@student.tarc.edu.my', '014-5569877', '981130125591', 'Pj02Njg1Njc6Oj42', 'M', true, 5, '2016/2017');

-- EVENT TABLE
CREATE TABLE EVENT (EVENTID VARCHAR(10) NOT NULL, EVENTNAME VARCHAR(255), EVENTTYPE INTEGER, EVENTDATE VARCHAR(25), EVENTSTARTTIME VARCHAR(20), EVENTENDTIME VARCHAR(20), EVENTLOCATION VARCHAR(255), PRIMARY KEY (EVENTID));

-- EVENTMEMBER TABLE (BRIDGE TABLE FOR MEMBER && EVENT)
CREATE TABLE EVENTMEMBER (EVENTMEMBERID VARCHAR(10) NOT NULL, MEMBERID VARCHAR(10), EVENTID VARCHAR(10), PRIMARY KEY (EVENTMEMBERID));

-- EVENTCOLLABORATOR TABLE (BRIDGE TABLE FOR EVENT && COLLABORATOR)
CREATE TABLE EVENTCOLLABORATOR (EVENTCOLLABID VARCHAR(10) NOT NULL, EVENTID VARCHAR(10), COLLABID VARCHAR(10), PRIMARY KEY (EVENTCOLLABID));

-- COLLABORATOR TABLE
CREATE TABLE COLLABORATOR (COLLABID VARCHAR(10) NOT NULL, COLLABNAME VARCHAR(255) NOT NULL, COLLABTYPE INTEGER NOT NULL, COLLABCONTACT VARCHAR(20) NOT NULL, COLLABEMAIL VARCHAR(255), ADDITIONALNOTES VARCHAR(255), PRIMARY KEY (COLLABID));

-- SPONSOREDITEM TABLE
CREATE TABLE SPONSOREDITEM (ITEMID VARCHAR(10) NOT NULL, COLLABID VARCHAR(10) NOT NULL, ITEMTYPE INTEGER NOT NULL, ITEMNAME VARCHAR(255) NOT NULL, ITEMQUANTITY INTEGER NOT NULL, PRIMARY KEY (ITEMID));

-- SPONSOREDITEM TABLE
CREATE TABLE EVENTITEM (EVENTITEMID VARCHAR(10)  NOT NULL, EVENTID VARCHAR(10), ITEMID VARCHAR(10), PRIMARY KEY (EVENTITEMID));

-- ALTER TABLE TO ADD FOREIGN KEY
ALTER TABLE EVENTMEMBER ADD FOREIGN KEY(MEMBERID) REFERENCES MEMBERS;
ALTER TABLE EVENTMEMBER ADD FOREIGN KEY(EVENTID) REFERENCES EVENT;
ALTER TABLE EVENTCOLLABORATOR ADD FOREIGN KEY(EVENTID) REFERENCES EVENT;
ALTER TABLE EVENTCOLLABORATOR ADD FOREIGN KEY(COLLABID) REFERENCES COLLABORATOR;
ALTER TABLE EVENTITEM ADD FOREIGN KEY(EVENTID) REFERENCES EVENT;
ALTER TABLE EVENTITEM ADD FOREIGN KEY(ITEMID) REFERENCES SPONSOREDITEM;
ALTER TABLE SPONSOREDITEM ADD FOREIGN KEY(COLLABID) REFERENCES COLLABORATOR;