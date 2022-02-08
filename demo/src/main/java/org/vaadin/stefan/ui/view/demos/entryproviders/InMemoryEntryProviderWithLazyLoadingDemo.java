package org.vaadin.stefan.ui.view.demos.entryproviders;

import com.vaadin.flow.router.Route;
import org.vaadin.stefan.fullcalendar.Entry;
import org.vaadin.stefan.fullcalendar.dataprovider.EntryProvider;
import org.vaadin.stefan.fullcalendar.dataprovider.EagerInMemoryEntryProvider;
import org.vaadin.stefan.fullcalendar.dataprovider.LazyInMemoryEntryProvider;
import org.vaadin.stefan.ui.MainLayout;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Stefan Uebe
 */
@Route(value = "in-memory-entry-provider-with-lazy-loading", layout = MainLayout.class)
@org.vaadin.stefan.ui.menu.MenuItem(label = "In Memory Entry Provider (lazy)")
public class InMemoryEntryProviderWithLazyLoadingDemo extends AbstractEntryProviderDemo {

    public InMemoryEntryProviderWithLazyLoadingDemo() {
        super(true, "TBD: lazy in memory provider");
    }

    @Override
    protected LazyInMemoryEntryProvider<Entry> getEntryProvider() {
        return (LazyInMemoryEntryProvider<Entry>) super.getEntryProvider();
    }

    @Override
    protected void onSamplesCreated(List<Entry> entries) {
        LazyInMemoryEntryProvider<Entry> provider = getEntryProvider();
        provider.addEntries(entries);
        provider.refreshAll();
    }

    @Override
    protected void onSamplesRemoved() {
        LazyInMemoryEntryProvider<Entry> provider = getEntryProvider();
        provider.removeAllEntries();
        provider.refreshAll();
    }

    @Override
    protected EntryProvider<Entry> createEntryProvider(EntryService service) {
        return new LazyInMemoryEntryProvider<>(service.streamEntries().collect(Collectors.toList()));
    }
}
