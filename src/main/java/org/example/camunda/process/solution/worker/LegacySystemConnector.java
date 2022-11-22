package org.example.camunda.process.solution.worker;

import org.example.camunda.process.solution.LegacyVariables;

import io.camunda.connector.api.annotation.OutboundConnector;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;

@OutboundConnector(name = "LegacySystem", inputVariables = { "token", "request",
        "businessKey" }, type = "io.camunda.example.LegacySystemConnector:1")
public class LegacySystemConnector implements OutboundConnectorFunction {

    @Override
    public Object execute(OutboundConnectorContext ctx) throws Exception {
        LegacyVariables vars = ctx.getVariablesAsType(LegacyVariables.class);

        ctx.replaceSecrets(vars);
        ctx.validate(vars);

        return new LegacyResponse(true, 42);
    }
}