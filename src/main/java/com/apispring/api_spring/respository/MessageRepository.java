package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Message;
import com.apispring.api_spring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query(value = "SELECT m FROM Message m where m.messageId.senderAccountId = :accountId")
    List<Message> findMessageBySenderAccountId(@Param("accountId") int accountId);

    @Query ("SELECT s " +
            " FROM Student  s" +
            " where s.studentId IN  (SELECT sl.studentClassId.studentId from StudentClass sl where sl.studentClassId.classId  = :classID) " +
            " and s.name like CONCAT(CONCAT('%', :name), '%')")
    List<Student> getAllStudentInClassBySimilarName (String classID, String name);

    @Query ("SELECT s " +
            " FROM Student  s" +
            " where s.studentId IN (SELECT sl.studentClassId.studentId from StudentClass sl " +
            "where sl.studentClassId.classId " +
            " IN (SELECT c.classId FROM Class c where c.teacher.teacherId = :teacherID)) " +
            " and s.name like CONCAT(CONCAT('%', :name), '%')")
    List<Student> getAllStudentOfTeacherWithSimilarName (@Param("teacherID")String teacherID, @Param("name") String name);

//    @Query(value = "SELECT m FROM Message m WHERE Message.messageId.senderAccountId = :senderAccountId AND Message.messageId.receiverAccountId =:receiverAccountId")
//    List<Message> findMessageByTwoAccountId(@Param("senderAccountId") int senderAccountId, @Param("receiverAccountId") int receiverAccountId);

    //public List<Message> findMessagesBySenderAccount_AccountIdAndReceiverAccount_AccountId(int accountIdSender, int accountIdReceiver);

    @Query("SELECT m FROM Message m where ((m.messageId.senderAccountId=:senderAccountID and m.messageId.receiverAccountId = :receiverAccountID) " +
            " or (m.messageId.senderAccountId=:receiverAccountID and m.messageId.receiverAccountId = :senderAccountID))")
    List<Message> getMessageBetweenUsers(@Param("senderAccountID") int senderAccountID,@Param("receiverAccountID") int receiverAccountID);

    public List<Message> findMessagesBySenderAccount_AccountIdOrReceiverAccount_AccountId(int accountId, int accountId2);

    @Query("SELECT mess FROM Message mess where (mess.senderAccount.accountId=:senderAccountID and mess.receiverAccount.accountId = :receiverAccountID) " +
            " or (mess.senderAccount.accountId=:receiverAccountID and mess.receiverAccount.accountId = :senderAccountID)")
    public List<Message> getMessageBetweenUsersAccount(@Param("senderAccountID") int senderAccountID,@Param("receiverAccountID")  int receiverAccountID);
}