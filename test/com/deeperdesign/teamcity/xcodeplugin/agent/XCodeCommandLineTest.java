/*
 * Copyright (c) 2008 Oliver Jones.  See LICENSE file for details.
 */

package com.deeperdesign.teamcity.xcodeplugin.agent;

import java.util.HashMap;
import java.util.List;
import static org.easymock.EasyMock.*;
import java.util.Map;
import jetbrains.buildServer.agent.AgentRunningBuild;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oliver
 */
public class XCodeCommandLineTest {

    public XCodeCommandLineTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getArguments method, of class XCodeCommandLine.
     */
    @Test
    public void testGetArguments() throws Exception {
        AgentRunningBuild mockBuild = createMock(AgentRunningBuild.class);
        Map<String, String> mockParams = new HashMap<String, String>();

        expect(mockBuild.getRunnerParameters()).andReturn(mockParams);
        
        replay(mockBuild);
        
        XCodeCommandLine instance = new XCodeCommandLine(mockBuild);
        List<String> args = instance.getArguments();
        assertNotNull(args);
        assertTrue(args.isEmpty());
        
    }

    // TODO test that the correct argument list is built from different combinations of params
    
    /**
     * Test of getExecutablePath method, of class XCodeCommandLine.
     */
    @Test
    public void testGetExecutablePath() throws Exception {
        AgentRunningBuild mockBuild = createMock(AgentRunningBuild.class);
        replay(mockBuild);
        
        XCodeCommandLine instance = new XCodeCommandLine(mockBuild);

        String result = instance.getExecutablePath();
        assertNotNull(result);               
    }

}