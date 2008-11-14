/*
 * Copyright (c) 2008 Oliver Jones.  See LICENSE file for details.
 */

package com.deeperdesign.teamcity.xcodeplugin.agent;

import java.io.File;
import java.util.Map;
import jetbrains.buildServer.agent.CurrentBuildTracker;
import jetbrains.buildServer.agent.DataProcessor;
import jetbrains.buildServer.agent.inspections.InspectionReporter;

import com.deeperdesign.teamcity.xcodeplugin.common.PluginConstants;

/**
 *
 * @author oliver
 */
public class XCodeDataProcessor implements DataProcessor {

  public XCodeDataProcessor(final CurrentBuildTracker currentBuild,
                            final InspectionReporter reporter) {
    //myCurrentBuild = currentBuild;
    //myReporter = reporter;
    }

    public String getId() {
        return PluginConstants.RUNNER_TYPE;
    }

    public void processData(File file, final Map<String, String> arguments) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
