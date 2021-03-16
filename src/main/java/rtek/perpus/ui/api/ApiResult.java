package rtek.perpus.ui.api;

import java.util.List;

public class ApiResult<T> {
    private List<T> data;
    private Metadata metadata;

    public ApiResult() {
        metadata = new Metadata();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
