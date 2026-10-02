package com.frndchat.chatbackend.repository;

import com.frndchat.chatbackend.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySenderIdAndReceiverIdOrderByTimestampAsc(
            String senderId,
            String receiverId
    );

    List<Message> findByReceiverIdOrderByTimestampAsc(
            String receiverId
    );

    List<Message> findByReceiverIdAndReadFalseOrderByTimestampAsc(
            String receiverId
    );

    long countByReceiverIdAndReadFalse(String receiverId);
}