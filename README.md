###### Network policies

In order to enable Container-to-container communication, please, add following network policies

```cf network-policies

source             destination        protocol   ports   destination space   destination org
order-service      discovery-server   tcp        8080    Training            grapeup
customer-service   discovery-server   tcp        8080    Training            grapeup
customer-service   order-service      tcp        8080    Training            grapeup
```
