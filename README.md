# To Knows...

## Replication factor VS In Sync Replica (ISR)

### Replication factor
- The number of copies of each partition that Kafka maintains across the cluster.
- The replication factor should always be less than or equal to the number of brokers in the cluster.
- If you set the replication factor to be more than the number of brokers in the cluster, you will get an error when you
  try to create a topic.
- The replication factor is used to provide fault tolerance. If a broker goes down, another broker can serve the data.
- The replication factor is set at the time of topic creation and can be modified later.

### In Sync Replica (ISR)
- The in-sync replica set (ISR) is the set of replicas that are in sync with the leader.
- The leader is the replica that is currently serving the data.
- The ISR is the set of replicas that are in sync with the leader.
- The ISR is used to provide fault tolerance. If the leader goes down, one of the replicas in the ISR can be elected as
  the new leader.
