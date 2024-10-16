package Airlines.Pojos;

import com.fasterxml.jackson.annotation.JsonKey;
import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;
import com.poiji.annotation.ExcelSheet;

public class AirlinePoiji {


    @ExcelCell(0)
    private int id;
    @ExcelCellName("Name")
    private String name;
    @ExcelCellName("Name")
    private String country;
    @ExcelCellName("Name")
    private String logo;
    @ExcelCellName("Name")
    private String slogan;
    @ExcelCellName("Name")
    private String headquoters;
    @ExcelCellName("Name")
    private String website;
    @ExcelCellName("Name")
    private String established;
    @ExcelCellName("Name")
    private String established1;
@ExcelRow
    private String sheetname;
}
