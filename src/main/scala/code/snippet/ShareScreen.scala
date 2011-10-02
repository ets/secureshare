package code
package snippet 
/*******************************************************************************
 * Copyright 2011 Pascal Metrics
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import net.liftweb._
import http._
import java.util.Date
import code.lib._
import Helpers._

object ShareScreen extends LiftScreen {
  val email = field("From","")
  val emails = field("To","Separate multiple emails with commas")      
  val message = field("Message","Optional")
  val subject = field("Subject","Optional")

  val upload = new Field {
    /**
     * Set to true if this field is part of a multi-part mime upload
     */
    override def uploadField_? = true

    type ValueType = Array[Byte]

    def manifest = scala.Predef.manifest[Array[Byte]]

    def name = "Upload"

    def default = new Array[Byte](0)

    override def toForm = Full(SHtml.fileUpload(fph => set(fph.file)))

  }    
  
  override def finishButton = <button id="sendFile">Send Securely</button>
  override def cancelButton = <div style="visibility:hidden">I'm hidden</div> 
  
  def finish() {
    S.notice("From: "+email)
    S.notice("To: "+emails)
  }  
}