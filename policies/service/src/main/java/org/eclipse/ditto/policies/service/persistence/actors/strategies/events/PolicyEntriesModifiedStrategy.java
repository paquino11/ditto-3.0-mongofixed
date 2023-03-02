/*
 * Copyright (c) 2019 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.ditto.policies.service.persistence.actors.strategies.events;

import org.eclipse.ditto.policies.model.Policy;
import org.eclipse.ditto.policies.model.PolicyBuilder;
import org.eclipse.ditto.policies.model.signals.events.PolicyEntriesModified;

/**
 * This strategy handles {@link org.eclipse.ditto.policies.model.signals.events.PolicyEntriesModified} events.
 */
final class PolicyEntriesModifiedStrategy extends AbstractPolicyEventStrategy<PolicyEntriesModified> {

    @Override
    protected PolicyBuilder applyEvent(final PolicyEntriesModified pem, final Policy policy,
            final PolicyBuilder policyBuilder) {
        return policyBuilder
                .removeAll(policy.getEntriesSet())
                .setAll(pem.getPolicyEntries());
    }
}
