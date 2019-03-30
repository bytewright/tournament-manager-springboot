INSERT INTO users
VALUES (0, 0, NOW(), NOW(), 'admin', '$2a$08$7xqulWByb76zrZI2ygOdteEEdK3QtXkOIHGbnvfYVoMyyHWsP6lo6', 'admin@admin.adm',
        'USER;ADMIN', false);

INSERT INTO users
VALUES (1, 0, NOW(), NOW(), 'user1', '$2a$08$mVw76.4FzClKKQ5EP1Uq4OhZ/Hn9.MKKl6CZie2seKC6F/j4T.pPS', 'user1@user1.adm',
        'USER', false);

INSERT INTO users
VALUES (2, 0, NOW(), NOW(), 'appUser', '$2a$08$3rC5aNqsAM0.qjRmzUHdVO/jQ2wtmerYSfH.Ywyz4RM7ydnfJC7wm',
        'appUser@appUser.ur', '', true);

INSERT INTO tournaments (ID, VERSION, CREATED_AT, UPDATED_AT, NAME, ROUND_COUNT, LOCATION_ADDRESS, PAGE_URL_PATH,
                         START_DATE, END_DATE, CREATOR_ID)
VALUES (1, 0, '2015-03-05 20:07:17.283000000', '2017-03-05 20:07:21.387000000', 'Kranich', 10, 'Berlin', 'kranich',
        '2019-03-05 20:08:07.723000000', '2019-03-10 20:08:09.683000000', 0);

INSERT INTO tournaments (ID, VERSION, CREATED_AT, UPDATED_AT, NAME, ROUND_COUNT, LOCATION_ADDRESS, PAGE_URL_PATH,
                         START_DATE, END_DATE, CREATOR_ID)
VALUES (2, 0, '2012-12-05 20:07:17.283000000', '2012-12-05 20:07:21.387000000', 'Kreuzschnitt', 7, 'Jena', 'jcc',
        '2020-12-04 20:08:07.723000000', '2020-12-07 20:08:09.683000000', 1);

INSERT INTO tournaments (ID, VERSION, CREATED_AT, UPDATED_AT, NAME, ROUND_COUNT, LOCATION_ADDRESS, PAGE_URL_PATH,
                         START_DATE, END_DATE, CREATOR_ID)
VALUES (3, 0, '2015-03-05 20:07:17.283000000', '2017-03-05 20:07:21.387000000', 'GO Team Tournament', 5, 'Hamburg', 'go-team-tournament',
        '2020-12-05 20:08:07.723000000', '2020-12-10 20:08:09.683000000', 1);

INSERT INTO players (ID, VERSION, CREATED_AT, UPDATED_AT, FIRST_NAME, LAST_NAME, EMAIL, PHONE, GENDER, AGE, CITY,
                     GO_RANK, STUDENT, REDUCED_FEE, CLUB_MEMBER, TOURNAMENT_ID)
VALUES (1, 1, '2019-03-05 20:09:24.808000000', '2019-03-05 20:09:25.993000000', 'Felix', 'Spieler',
        'TEST.PLAYER01@MAIL.COM', '015253/454', 'm', 25, 'Hamburg', '10k', false, false, false, 1);
INSERT INTO players (ID, VERSION, CREATED_AT, UPDATED_AT, FIRST_NAME, LAST_NAME, EMAIL, PHONE, GENDER, AGE, CITY,
                     GO_RANK, STUDENT, REDUCED_FEE, CLUB_MEMBER, TOURNAMENT_ID)
VALUES (2, 1, '2019-03-05 20:09:24.808000000', '2019-03-05 20:09:25.993000000', 'Max', 'Mustermann',
        'TEST.PLAYER02@MAIL.COM', '015253/454', 'm', 25, 'Hamburg', '10k', false, true, false, 1);
INSERT INTO players (ID, VERSION, CREATED_AT, UPDATED_AT, FIRST_NAME, LAST_NAME, EMAIL, PHONE, GENDER, AGE, CITY,
                     GO_RANK, STUDENT, REDUCED_FEE, CLUB_MEMBER, TOURNAMENT_ID)
VALUES (3, 1, '2019-03-05 20:09:24.808000000', '2019-03-05 20:09:25.993000000', 'Ababajabajabajabja', 'Berg',
        'TEST.PLAYER03@MAIL.COM', '015253/454', 'm', 25, 'Hamburg', '10k', false, false, true, 1);
INSERT INTO players (ID, VERSION, CREATED_AT, UPDATED_AT, FIRST_NAME, LAST_NAME, EMAIL, PHONE, GENDER, AGE, CITY,
                     GO_RANK, STUDENT, REDUCED_FEE, CLUB_MEMBER, TOURNAMENT_ID)
VALUES (4, 1, '2019-03-05 20:09:24.808000000', '2019-03-05 20:09:25.993000000', 'TEST', 'PLAYER',
        'TEST.PLAYER04@MAIL.COM', '015253/454', 'm', 25, 'Hamburg', '10k', false, false, false, 2);
INSERT INTO players (ID, VERSION, CREATED_AT, UPDATED_AT, FIRST_NAME, LAST_NAME, EMAIL, PHONE, GENDER, AGE, CITY,
                     GO_RANK, STUDENT, REDUCED_FEE, CLUB_MEMBER, TOURNAMENT_ID)
VALUES (5, 1, '2019-03-05 20:09:24.808000000', '2019-03-05 20:09:25.993000000', 'TEST', 'PLAYER',
        'TEST.PLAYER05@MAIL.COM', '015253/454', 'm', 25, 'Hamburg', '10k', true, false, true, 1);