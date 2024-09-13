**KAFKA**
Navigate to Kafka Directory --- cd path\to\kafka
Start Zookeeper Server -- .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
Start Kafka Server -- .\bin\windows\kafka-server-start.bat .\config\server.properties
Create a Topic -- .\bin\windows\kafka-topics.bat --create --topic your_topic_name --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1
List Topics -- .\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
Produce Messages to a Topic -- .\bin\windows\kafka-console-producer.bat --topic your_topic_name --bootstrap-server localhost:9092
Consume Messages from a Topic -- .\bin\windows\kafka-console-consumer.bat --topic your_topic_name --from-beginning --bootstrap-server localhost:9092
Delete a Topic -- .\bin\windows\kafka-topics.bat --delete --topic your_topic_name --bootstrap-server localhost:9092
Stop Kafka Server -- .\bin\windows\kafka-server-stop.bat
Stop Zookeeper Server -- .\bin\windows\zookeeper-server-stop.bat
Set JAVA_HOME (if needed) -- setx -m JAVA_HOME "C:\Java\jdk21
