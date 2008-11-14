/*
 * Copyright (c) 2008 Oliver Jones.  All rights reserved.
 */

package com.deeperdesign.teamcity.xcodeplugin.agent;

import jetbrains.buildServer.agent.*;
import jetbrains.buildServer.agent.runner.AbstractProcessBuildRunnerState;
import jetbrains.buildServer.agent.runner.ProgramCommandLine;

/**
 *
 * @author oliver
 */
public class XCodeRunnerState extends AbstractProcessBuildRunnerState {

    public XCodeRunnerState(final AgentRunningBuild build) {
        super(build);
    }

    public ProgramCommandLine getProgramCommandLine() {
        return new XCodeCommandLine(getBuild());
    }

    @Override
    public BuildFinishedStatus getRunResult(int exitCode) {
        return super.getRunResult(exitCode);
    } 
}
