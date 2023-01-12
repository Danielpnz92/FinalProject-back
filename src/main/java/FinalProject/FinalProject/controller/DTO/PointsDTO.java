package FinalProject.FinalProject.controller.DTO;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PointsDTO {
    private Double points;

    public PointsDTO(Double points) {
        this.points = points;
    }

    public Double getPoints() {
        return points;
    }
}
