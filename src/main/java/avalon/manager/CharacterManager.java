package avalon.manager;

import avalon.model.character.Character;
import avalon.model.items.InventoryMaterial;
import avalon.model.items.material.Material;
import avalon.model.user.User;
import avalon.repository.MaterialRepository;
import avalon.request.NewCharacterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CharacterManager {

    @Autowired
    private MaterialRepository materialRepository;

    public Character createCharacter(User user, NewCharacterRequest newCharacterRequest) {
        Character character = new Character();
        character.setUser(user);
        character.setName(newCharacterRequest.name);

        // create inventory and shit for debugging
        Set<InventoryMaterial> invMats = new HashSet<>();
        List<Material> mats = materialRepository.findAll();
        for (Material mat : mats) {
            InventoryMaterial invMat = new InventoryMaterial();
            invMat.setMaterial(mat);
            invMat.setCharacter(character);
            invMat.setQuantity(5);
            invMats.add(invMat);
        }
        character.setInventoryMaterials(invMats);

        new Material();

        return character;
    }

}
