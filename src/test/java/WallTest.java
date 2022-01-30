import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class WallTest {

    public class WallBlock implements Block {

        private String color;
        private String material;

        public WallBlock(String color, String material) {
            this.color = color;
            this.material = material;
        }

        @Override
        public String getColor() {
            return color;
        }

        @Override
        public String getMaterial() {
            return material;
        }
    }
    WallBlock wallBlock1= new WallBlock("Red", "Brick");
    WallBlock wallBlock2= new WallBlock("Blue", "Brick");
    WallBlock wallBlock3= new WallBlock("Green", "Gyspum");

    List<Block> blocks = List.of(wallBlock1, wallBlock2, wallBlock3);

    @Test
    public void shouldReturnBlockWithColorGreen() {
    //given
    Wall wall = new Wall(blocks);
    //when
    Optional result = wall.findBlockByColor("green");
    //then
    assertThatObject(result).isEqualTo(Optional.of(wallBlock3));
    }

    @Test
    public void shouldReturnListOfBlocksWithMaterialBrick() {
        //given
        List<WallBlock> blocksOfBrick = List.of(wallBlock1,wallBlock2);
        Wall wall = new Wall(blocks);
        //when
        List<Block> result = wall.findBlocksByMaterial("brick");
        //then
        assertThat(result).isEqualTo(blocksOfBrick);
    }

    @Test
    public void shouldReturnTheQuantityOfBlocksInWall() {
        //given
        Wall wall = new Wall(blocks);
        //when
        Integer result = wall.count();
        //then
        assertThat(result).isEqualTo(3);
    }

}