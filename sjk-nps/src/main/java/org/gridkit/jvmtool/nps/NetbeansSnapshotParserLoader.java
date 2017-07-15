/**
 * Copyright 2017 Alexey Ragozin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gridkit.jvmtool.nps;

import java.io.IOException;

import org.gridkit.jvmtool.event.Event;
import org.gridkit.jvmtool.event.EventDumpParser;
import org.gridkit.jvmtool.event.EventReader;

public class NetbeansSnapshotParserLoader implements EventDumpParser {

	private static EventDumpParser PARSER;

	static {
		PARSER = new NetbeansSnapshotParserBootstrapper().load();
	}
	
	@Override
	public EventReader<Event> open(InputStreamSource source) throws IOException {
		if (PARSER == null) {
			return null;
		}
		return PARSER.open(source);
	}
	
	@Override
	public String toString() {
		return "Netbeans Profiler Snapshot" + (PARSER == null ? " (not loaded)" : "");
	}
}
