-- anunturi pt un curs
DELIMITER $$
DROP PROCEDURE IF EXISTS `pc221`.`announce_for_course`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `pc221`.`announce_for_course`(IN param6 INT)
BEGIN
	SELECT * FROM announcement a 
	inner join teachers t on a.teacherId = t.teacherId
	where csid = param6;
END$$
DELIMITER ;

-- cursurile unei specializari
DELIMITER $$
DROP PROCEDURE IF EXISTS `pc221`.`courses_for_specialty`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `pc221`.`courses_for_specialty`(IN param4 INT)
BEGIN
	select s.csId, c.courseName, s.courseCode, s.courseType, s.courseCredits, s.semester 
	from courses c inner join specializations_courses s on c.courseId = s.courseId 
	where s.spId = param4;
END$$
DELIMITER ;

-- notele la un examen
DELIMITER $$
DROP PROCEDURE IF EXISTS `pc221`.`grades_for_exam`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `pc221`.`grades_for_exam`(IN param3 INT)
BEGIN
	select  userName, grade 
	from students_specializations ss
	inner join grades g on g.ssId=ss.ssId 
	inner join exams e on g.csId=e.csId and g.type = e.type
	inner join students s on s.studentId=ss.studentId
	where examId = param3; 
END$$
DELIMITER ;

-- rezolvarile unei teme
DELIMITER $$
DROP PROCEDURE IF EXISTS `pc221`.`solutions_for_assign`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `pc221`.`solutions_for_assign`(IN param2 INT)
BEGIN
	select solution, completed, userName 
	from solutions sl inner join students_specializations ss on sl.ssId = ss.ssId 
	inner join students st on ss.studentId = st.studentId 
	where sl.assignmentId = param2;
END$$
DELIMITER ;

-- specializarile unei facultati
DELIMITER $$
DROP PROCEDURE IF EXISTS `pc221`.`specialties_for_faculty`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `pc221`.`specialties_for_faculty`(IN param5 INT)
BEGIN
	select * from specializations 
	where spId in (
	select spId from faculties specializations 
	where facultyId = param5); 
END$$
DELIMITER ;

-- profesorii unui curs
DELIMITER $$
DROP PROCEDURE IF EXISTS `pc221`.`teachers_for_course`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `pc221`.`teachers_for_course`(IN param1 INT)
BEGIN
	select userName 
	from teachers t inner join teachers_spec ts on t.teacherId = ts.teacherId
	inner join specializations_courses s on ts.csId = s.csId 
	where s.csId = param1;
END$$
DELIMITER ;

-- grupele unui profesor
DELIMITER $$
DROP PROCEDURE IF EXISTS `pc221`.`groups_for_teacher`$$
CREATE PROCEDURE `pc221`.`groups_for_teacher` (IN param7 VARCHAR(255))
BEGIN
	select g.name 
	from groups g 
	inner join teachers_groups tg on g.groupId = tg.groupId
	inner join teachers_spec ts  on tg.tsId = ts.tsid 
	inner join teachers t on ts.teacherId = t.teacherId
	where t.userName = param7;
END$$
DELIMITER ;

-- cursurile dintr-un contract
DELIMITER $$
DROP PROCEDURE IF EXISTS `pc221`.`courses_for_contract`$$
CREATE PROCEDURE `pc221`.`courses_for_contract` (IN param9 INT)
BEGIN
	select courseCode from 
	contracts_data cd inner join specializations_courses sc 
	on cd.csId=sc.csId 
	where contractId = param9;
END$$
DELIMITER ;

-- studentii unei grupe
DELIMITER $$
DROP PROCEDURE IF EXISTS `pc221`.`students_for_group`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `students_for_group`(IN param8 INT)
BEGIN
	select c.contractId,ss.ssId,ss.studentId,ss.serialNumber,
				 s.personalCode,u.firstName,u.lastName,u.password,u.userName from
	groups g inner join students_specializations ss on g.spId=ss.spId
	inner join students s on ss.studentId=s.studentId 
	inner join users u on s.userName=u.userName 
	inner join contracts c on c.ssId=ss.ssId
	where g.groupId=param8;
END$$
DELIMITER ;

-- cursuri pt un profesor
DELIMITER $$
DROP PROCEDURE IF EXISTS `pc221`.`courses_for_teacher`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `courses_for_teacher`(IN param10 VARCHAR(255))
BEGIN
	select sc.courseCode 
	from specializations_courses sc inner join teachers_spec ts  on sc.csId = ts.csId
	inner join teachers t on ts.teacherId = t.teacherId
	inner join users u on u.userName = t.userName
	where u.username = param10;
END$$
DELIMITER ;
