/*
 * Copyright (c) 2008 Oliver Jones.  All rights reserved.
 */

package com.deeperdesign.teamcity.xcodeplugin.agent;

import com.deeperdesign.teamcity.xcodeplugin.common.PluginConstants;
import jetbrains.buildServer.agent.*;
import jetbrains.buildServer.agent.artifacts.ArtifactsWatcher;
import jetbrains.buildServer.agent.runner.ProcessBuildRunner;
import jetbrains.buildServer.agent.runner.ProcessBuildRunnerState;

/**
 *
 * @author oliver
 */
public class XCodeRunner implements ProcessBuildRunner {

    public XCodeRunner(final ArtifactsWatcher artifactsWatcher,
                       final XCodeDataProcessor dataProcessor) {
    //myArtifactsWatcher = artifactsWatcher;
    //myDataProcessor = dataProcessor;
    }
   
    
    public boolean canRun(BuildAgentConfiguration agentConfiguration) {
        BuildAgentSystemInfo info = agentConfiguration.getSystemInfo();
        if(info.isMac())
        {
            return true;
        }     
        
        return false;
    }

    public String getType() {
        return PluginConstants.RUNNER_TYPE;
    }

    
    public ProcessBuildRunnerState runBuild(final AgentRunningBuild runningBuild) {
        return new XCodeRunnerState(runningBuild);
    }
    
}
