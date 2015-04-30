/**
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neo4art.literature.deprecated;

import org.neo4art.sentiment.deprecated.SentimentInfo;

/**
 * 
 * @author Lorenzo Speranzoni, Enrico De Benetti
 * @since 22.04.2015
 */
@Deprecated
public interface SentimentRepository {

  long addWord(long currentNodeId, String word, SentimentInfo sentimentInfo);

  long addWordByRedundantPath(long currentNodeId, String word, SentimentInfo sentimentInfo);
  
  void createRelationship(long startNodeId, long endNodeId, SentimentInfo sentimentInfo, boolean wordExists);

  void mergeRelationship(long startNodeId, long endNodeId, SentimentInfo sentimentInfo, boolean wordExists);
}
