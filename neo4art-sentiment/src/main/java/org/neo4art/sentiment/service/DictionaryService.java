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

package org.neo4art.sentiment.service;

import java.io.IOException;

/**
 * @author Lorenzo Speranzoni
 * @since 29 Apr 2015
 */
public interface DictionaryService
{
  /**
   * 
   */
  void createLegacyIndexes();
  
  /**
   * @throws IOException
   */
  void saveDictionary() throws IOException;

  /**
   * @throws IOException
   */
  void addPolarity() throws IOException;

  /**
   * @param word
   * @return
   */
  long mergeWordAndFlush(String word);

  /**
   * @param word
   * @return
   */
  long mergeWordWithoutFlushing(String word);
}
