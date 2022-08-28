package co.edu.udea.compumovil.gr04_20221.notecad.di

import co.edu.udea.compumovil.gr04_20221.notecad.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun CourseRepositoryRoome(repo: CourseRepositoryRoom): CourseRepository

    @Binds
    @Singleton
    abstract fun GradeRepositoryRoom(repo: GradeRepositoryRoom): GradeRepository

    @Binds
    @Singleton
    abstract fun ScheduleRepositoryRoom(repo: ScheduleRepositoryRoom): ScheduleRepository

}