=======================================================================================================================================================================
Architecture:
=======================================================================================================================================================================

                    +------------------+
                    |  order-service   |
                    +------------------+
                             |
                             | order-created (Topic)
                             v
                    +------------------+
                    | payment-service  |
                    +------------------+
                             |
                             | payment-succeeded (Topic)
                             v
                    +------------------+
                    | inventory-service|
                    +------------------+
                      |            |
                      |            |
 inventory-reserved   |            | inventory-failed (Topic)
 (Topic)              |            |
                      v            v
            +----------------+   +----------------+
            | order-service  |   | payment-service|
            +----------------+   +----------------+
                  |                    |
              COMPLETED                |
                                       | payment-refunded (Topic)
                                       |
                                       v
                               +----------------+
                               | order-service  |
                               +----------------+
                                       |
                                   CANCELLED





EDA SYSTEM DESIGN / CASE STUDY
------------------------------------------------------------
- Identify where asynchronous communication is useful
- Identify events
- Identify producers and consumers
- Choose Kafka/RabbitMQ where appropriate
- Design event flow
- Handle failures
- Handle duplicates
- Handle retries
- Handle ordering
- Handle slow consumers
- Identify eventual consistency
- Identify scalability concerns
- Identify trade-offs
- Reverse-engineer an existing real-world architecture




Why is this synchronous?
Why is this asynchronous?
Why Kafka here?
Why this topic?
Who owns the event?
How is the event structured?
How is ordering handled?
What happens if the consumer is down?
What happens if processing fails?
What happens if the same event arrives twice?
Why is there an outbox?
Why is there a retry/DLT?
Where does eventual consistency appear?
How does the Saga progress?
How does each service maintain its own data?
Where are the scalability boundaries?
Where are the failure boundaries?



1. Understand the business problem
             ↓
2. Identify the services
             ↓
3. Build the high-level architecture
             ↓
4. Trace one Order end-to-end
             ↓
5. Identify synchronous vs asynchronous communication
             ↓
6. Trace Kafka topics + events
             ↓
7. Trace the Outbox
             ↓
8. Trace consumers + idempotency
             ↓
9. Trace failures + Retry/DLT
             ↓
10. Trace the Saga
             ↓
11. Understand scaling / partitions / consumer groups
             ↓
12. Finally inspect the actual code


