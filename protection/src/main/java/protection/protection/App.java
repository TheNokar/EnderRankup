package protection.protection;

import java.io.File;
import java.util.logging.Logger;

import org.spongepowered.api.Game;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.state.InitializationEvent;
import org.spongepowered.api.event.state.PostInitializationEvent;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.service.config.DefaultConfig;

import com.google.inject.Inject;

@Plugin(id = "example", name = "Example", version = "v0.1")
public class App {
    
    @Inject private Logger log;
    @Inject private Game game;
    @Inject @DefaultConfig(sharedRoot = false) private File defaultConfig;
    
    @Subscribe
    public void preinit(PreInitializationEvent event) {
        
    }
    
    @Subscribe
    public void init(InitializationEvent event) {
        
    }
    
    @Subscribe
    public void postinit(PostInitializationEvent event) {
        
    }
}
