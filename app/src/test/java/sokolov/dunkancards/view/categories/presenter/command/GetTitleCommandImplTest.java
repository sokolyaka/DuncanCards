package sokolov.dunkancards.view.categories.presenter.command;

import org.junit.Test;

import sokolov.dunkancards.data.repository.i18n.InMemoryStringsRepository;
import sokolov.dunkancards.data.repository.mock.MockSettingsRepository;

import static org.junit.Assert.assertEquals;

public class GetTitleCommandImplTest {

    @Test
    public void getTitle() throws Exception {
        new GetTitleCommandImpl(
                new MockSettingsRepository("uk"),
                new InMemoryStringsRepository())
        .execute(new GetTitleCommand.Callback() {

            @Override
            public void onSuccess(String title) {
                assertEquals(
                        "Картки Домана",
                        title);

            }

            @Override
            public void onError(Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}