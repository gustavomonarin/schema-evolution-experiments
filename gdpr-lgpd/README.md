Complying with Gdpr simply, flexible and extensible

Pii-Schema

# Intro
While testing out with the new schema support available in the ecosystem and its best practice, more specifically protobuf, was surprised to not find open references of implementing personal data protection. Please see kafka references and general information to the link of the solutions found.

This repo intends to present some experimentation on gdpr which were not ...

Further more provide an ?open? space to collaborate in a so complex subject and with so many possible combinations for example with cloud kms implementations, use cases  as Acls including the extense kafka ecosystem. 

## Project Goals
* Gdpr compliant / right to be forgotten
* No deletion, event loss, data los of non personal data
* Explicit data classification over implicit encryption (as part of the schema)
* Composable with the current kafka clients / serializers
* Composable with different key management systems
* Composable with the kafka ecosystem (could be used directly by the client or by a kafka connect)
* Yet, providing a simple implementation
* Composability should enable different Acls/ways to access data from different consumers


## Background

* Event driven architectures and its persistence is finally becoming known and becoming the new core.
    - The new source of true
    - Streaming platforms with long term durability rather than data in transit, specially with KIP-405
    - Streaming platforms extending to provide database like operations instead of the opposite - lsm ;) 
* Data governance at center with personal data laws (gdpr/lgpd)
    - Maturity levels - Early, many times mixed with bureaucracy and spreadsheets
    

    
## Challenges

* Multiple areas of  knowledge:
    - Serializers (Avro, Protobuf, Json Schema, ...)
    - Schema registries (Confluent, Apiario, ...)
    - Cryptography / shredding approach
    - Multiple kms implementations (aws, gcp, ...)


## Next steps

* DelegateSecretKey and cloud implementations/providers
* Secret keys wrapping and Acls
* Multi language support similar to librdkafka implemented in rust
* Extending schema support/vocabulary

# See also

## Alternative approaches


## kafka references


* [ben on compact topics/tombstone and retention periods](https://www.confluent.io/blog/handling-gdpr-log-forget/1)
* [similar to initial tought, but with a topic in the middle](https://danlebrero.com/2018/04/11/kafka-gdpr-event-sourcing/)
* [event sourcing and gdpr](https://www.michielrook.nl/2017/11/forget-me-please-event-sourcing-gdpr/)

* [life as event of stream - tombstone - reach out @jocumsen as he was investigating alternatives](https://www.confluent.io/kafka-summit-sf18/life-is-a-stream-of-events/)
* [Babylon health use case, really nice usage of composed keys/custom key extractor. Not so nice when handling gdpr-tombstone](https://www.confluent.io/kafka-summit-lon19/one-key-to-rule-them-all/)

* [Anna Kepler, Viasat on authorization and custom http authorizer](https://www.confluent.io/kafka-summit-ny19/kafka-pluggable-auth-for-enterprise-security/)

## General implementations (mainly non free) references
* [Gdpr checklist](https://gdpr.eu/checklist/)
* [Dynamo client encryption](https://github.com/aws/aws-dynamodb-encryption-java/)
* [Akka support for gdpr](https://doc.akka.io/docs/akka-enhancements/current/gdpr/index.html)
* [Axon support for gdpr](https://axoniq.io/product-overview/axon-data-protection)
