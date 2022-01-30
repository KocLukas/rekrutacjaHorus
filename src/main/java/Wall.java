import java.util.List;
import java.util.Optional;

public class Wall implements Structure, CompositeBlock{

    private List<Block> blocks;

    public List<Block> getBlocks() {
        return blocks;
    }

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    // zwraca dowolny element o podanym kolorze
    public Optional findBlockByColor(String color) {
        for (Block block : blocks) {
            if (block.getColor().equalsIgnoreCase(color))
                return Optional.of(block);
        }
        return Optional.empty();
    }

    @Override
    // zwraca wszystkie elementy z danego materiału
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> matchedBlocks;
        matchedBlocks = blocks.stream()
                .filter(m -> m.getMaterial().equalsIgnoreCase(material))
                .toList();
        return matchedBlocks;
    }

    @Override
    //zwraca liczbę wszystkich elementów tworzących strukturę
    public int count() {
        return this.blocks.size();
    }
}
