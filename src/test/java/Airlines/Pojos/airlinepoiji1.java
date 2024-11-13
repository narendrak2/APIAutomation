package Airlines.Pojos;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;
import com.poiji.annotation.ExcelSheet;
import lombok.ToString;



@ToString


public class airlinepoiji1 {

    @ExcelCell(0)
    private int testid;

    @ExcelCellName("Module")
    private String module;

    @ExcelCellName("As")
    private String As;

    @ExcelCellName("Iwantto")
    private String Iwantto;

    @ExcelCellName("Sothat")
    private String Sothat;

    @ExcelCellName("Technicalsteps")
    private String Technicalsteps;

}
