/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springblade.core.log.publisher;

import org.springblade.core.log.constant.EventConstant;
import org.springblade.core.log.event.BladeLogEvent;
import org.springblade.core.tool.utils.SpringUtil;
import org.springblade.core.tool.utils.WebUtil;
import org.springblade.core.log.model.LogBlade;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * BLADE日志信息事件发送
 */
public class BladeLogPublisher {

    public static void publishEvent(String level, String id, String data) {
        HttpServletRequest request = WebUtil.getRequest();
        LogBlade logBlade = new LogBlade();
        logBlade.setLogLevel(level);
        logBlade.setLogId(id);
        logBlade.setLogData(data);
        Map<String, Object> event = new HashMap<>();
        event.put(EventConstant.EVENT_LOG, logBlade);
        event.put(EventConstant.EVENT_REQUEST, request);
        SpringUtil.publishEvent(new BladeLogEvent(event));
    }

}