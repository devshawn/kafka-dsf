package com.devshawn.kafka.gitops.domain.state.service

import com.devshawn.kafka.gitops.domain.options.GetAclOptions
import com.devshawn.kafka.gitops.domain.state.AclDetails
import spock.lang.Specification

class ApplicationServiceSpec extends Specification {

    void 'test consumer and producer ACLs'() {
        setup:
        ApplicationService sut = new ApplicationService.Builder()
                .setPrincipal("principal")
                .addConsumes("consumer-topic")
                .addProduces("producer-topic")
                .build()

        when:
        List<AclDetails.Builder> result = sut.getAcls(new GetAclOptions.Builder()
                .setServiceName("application-serivce").setDescribeAclEnabled(false).build())

        then:
        result
        result.size() == 3
    }
}
