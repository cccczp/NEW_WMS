package com.zorax.wms.tool;

import androidx.annotation.IntDef;

import static com.zorax.wms.tool.InstoreConstantTool.INSTOREMSG_LOC;
import static com.zorax.wms.tool.InstoreConstantTool.INSTOREMSG_MATERIALBARCODE;
import static com.zorax.wms.tool.InstoreConstantTool.INSTOREMSG_TRAY;
import static com.zorax.wms.tool.InstoreConstantTool.ORDERMSG;


/**
 * @创作者 czp
 * @创作时间 2021/5/29 15:18
 * @描述
 */
@IntDef({ORDERMSG,INSTOREMSG_LOC,INSTOREMSG_TRAY,INSTOREMSG_MATERIALBARCODE })
public @interface InstoreConstantTool {
    int ORDERMSG = 0;
    int INSTOREMSG_LOC = 1;
    int INSTOREMSG_TRAY = 2;
    int INSTOREMSG_MATERIALBARCODE = 3;
}
