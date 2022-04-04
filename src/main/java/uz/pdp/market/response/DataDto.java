package uz.pdp.market.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataDto<T> implements Serializable {
    protected T data;

    protected AppErrorDto error;

    protected boolean success;

    private Long totalCount;

    public DataDto(T data) {
        this.data = data;
        this.success = true;
    }

    public DataDto(AppErrorDto appErrorDto) {
        this.error = appErrorDto;
        this.success = false;
    }

    public DataDto(T data, Long totalCount) {
        this.data = data;
        this.totalCount = totalCount;
        this.success = true;
    }

}
